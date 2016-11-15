package com.kaltura.model.cache

import com.datastax.driver.core.Row
import com.datastax.driver.core.querybuilder.QueryBuilder
import com.kaltura.model.dao.PartnerDAO
import com.kaltura.model.entities.Partner
import com.kaltura.core.utils.ReadableTimeUnits._

/**
 * Created by ofirk on 07/02/2016.
 */
sealed class PartnerCache extends CacheBase[Partner, Int]{

  override val tableName = "dim_partners"
  override val idFieldName = "id"
  override def fromRow(row: Row) = if (row != null) Some(Partner(row.getInt("id"), Option(row.getString("secret")), Option(row.getString("crm_id")), Option(row.getInt("package_id")))) else None
  val ttl = 1 day

  def getById(id: Int) : Partner = {
    findById(id).getOrElse {
      println("Global cache miss")
      val partner = PartnerDAO.getById(id).getOrElse(Partner(id))
      cassandraSession.execute(QueryBuilder
        .insertInto(keySpace, tableName)
        .value("id", partner.id)
        .value("secret", partner.secret.orNull)
        .value("crm_id", partner.crmId.orNull)
        .value("package_id", partner.packageId.orNull)
        .using(QueryBuilder.ttl(ttl))
      )
      partner
    }
  }
}

object PartnerCache extends PartnerCache

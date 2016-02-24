package kanalony.storage.generated

import com.websudos.phantom.builder._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.dsl._

import scala.concurrent.Future

abstract class minutely_user_activity_prtn_entry_cf1TableAccessor extends CassandraTable[minutely_user_activity_prtn_entry_cf1TableAccessor, minutely_user_activity_prtn_entry_cf1Row] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object cf1 extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object count extends LongColumn(this)


  override def tableName = "minutely_user_activity_prtn_entry_cf1"

  def fromRow(row: Row): minutely_user_activity_prtn_entry_cf1Row = {
    minutely_user_activity_prtn_entry_cf1Row(
      partner_id(row), 
entry_id(row), 
cf1(row), 
metric(row), 
minute(row), 
count(row)
    )
  }

  def store(entity: minutely_user_activity_prtn_entry_cf1Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.entry_id, entity.entry_id)
.value(_.cf1, entity.cf1)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.count, entity.count)

      .future()
  }

  def query(partner_id : Int, entry_id : String, cf1 : String, metric : Int) : SelectQuery[minutely_user_activity_prtn_entry_cf1TableAccessor, minutely_user_activity_prtn_entry_cf1Row, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.cf1 eqs cf1)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, entry_id : String, cf1 : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_entry_cf1TableAccessor, minutely_user_activity_prtn_entry_cf1Row, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.cf1 eqs cf1)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
def query(partner_id_list : List[Int], entry_id_list : List[String], cf1_list : List[String], metric_list : List[Int]) : SelectQuery[minutely_user_activity_prtn_entry_cf1TableAccessor, minutely_user_activity_prtn_entry_cf1Row, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.cf1 in cf1_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], entry_id_list : List[String], cf1_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_entry_cf1TableAccessor, minutely_user_activity_prtn_entry_cf1Row, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.cf1 in cf1_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }

}
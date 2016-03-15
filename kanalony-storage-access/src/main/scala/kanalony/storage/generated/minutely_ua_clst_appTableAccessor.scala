package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class minutely_ua_clst_appTableAccessor extends CassandraTable[minutely_ua_clst_appTableAccessor, minutely_ua_clst_appRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object application extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "minutely_ua_clst_app"

  def fromRow(row: Row): minutely_ua_clst_appRow = {
    minutely_ua_clst_appRow(
      partner_id(row), 
metric(row), 
minute(row), 
application(row), 
value(row)
    )
  }

  def store(entity: minutely_ua_clst_appRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.application, entity.application)
.value(_.value, entity.value)

      .future()
  }

  def query(partner_id : Int, metric : Int) : SelectQuery[minutely_ua_clst_appTableAccessor, minutely_ua_clst_appRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
  }
 def query(partner_id : Int, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_clst_appTableAccessor, minutely_ua_clst_appRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id : Int, metric : Int, minuteStart : DateTime, minuteEnd : DateTime, applicationStart : String, applicationEnd : String) : SelectQuery[minutely_ua_clst_appTableAccessor, minutely_ua_clst_appRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.application gte applicationStart)
.and(_.application lt applicationEnd)
  }
def query(partner_id_list : List[Int], metric_list : List[Int]) : SelectQuery[minutely_ua_clst_appTableAccessor, minutely_ua_clst_appRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_clst_appTableAccessor, minutely_ua_clst_appRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id_list : List[Int], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime, applicationStart : String, applicationEnd : String) : SelectQuery[minutely_ua_clst_appTableAccessor, minutely_ua_clst_appRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.application gte applicationStart)
.and(_.application lt applicationEnd)
  }

}
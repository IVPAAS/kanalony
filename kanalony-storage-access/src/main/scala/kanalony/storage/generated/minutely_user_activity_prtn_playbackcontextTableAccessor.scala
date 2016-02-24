package kanalony.storage.generated

import com.websudos.phantom.builder._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.dsl._

import scala.concurrent.Future

abstract class minutely_user_activity_prtn_playbackcontextTableAccessor extends CassandraTable[minutely_user_activity_prtn_playbackcontextTableAccessor, minutely_user_activity_prtn_playbackcontextRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object playbackContext extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object count extends LongColumn(this)


  override def tableName = "minutely_user_activity_prtn_playbackcontext"

  def fromRow(row: Row): minutely_user_activity_prtn_playbackcontextRow = {
    minutely_user_activity_prtn_playbackcontextRow(
      partner_id(row), 
playbackContext(row), 
metric(row), 
minute(row), 
count(row)
    )
  }

  def store(entity: minutely_user_activity_prtn_playbackcontextRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.playbackContext, entity.playbackContext)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.count, entity.count)

      .future()
  }

  def query(partner_id : Int, playbackContext : String, metric : Int) : SelectQuery[minutely_user_activity_prtn_playbackcontextTableAccessor, minutely_user_activity_prtn_playbackcontextRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.playbackContext eqs playbackContext)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, playbackContext : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_playbackcontextTableAccessor, minutely_user_activity_prtn_playbackcontextRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.playbackContext eqs playbackContext)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
def query(partner_id_list : List[Int], playbackContext_list : List[String], metric_list : List[Int]) : SelectQuery[minutely_user_activity_prtn_playbackcontextTableAccessor, minutely_user_activity_prtn_playbackcontextRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.playbackContext in playbackContext_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], playbackContext_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_playbackcontextTableAccessor, minutely_user_activity_prtn_playbackcontextRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.playbackContext in playbackContext_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }

}
package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class TensecsUaPrtnCountryClstOsBrowserTableAccessor extends CassandraTable[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object country extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object tensecs extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object operating_system extends IntColumn(this)with ClusteringOrder[Int] with Ascending
object browser extends IntColumn(this)with ClusteringOrder[Int] with Ascending
object value extends LongColumn(this)


  override def tableName = "tensecs_ua_prtn_country_clst_os_browser"

  def fromRow(row: Row): TensecsUaPrtnCountryClstOsBrowserRow = {
    TensecsUaPrtnCountryClstOsBrowserRow(
      partner_id(row), 
country(row), 
metric(row), 
tensecs(row), 
operating_system(row), 
browser(row), 
value(row)
    )
  }

  def store(entity: TensecsUaPrtnCountryClstOsBrowserRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.country, entity.country)
.value(_.metric, entity.metric)
.value(_.tensecs, entity.tensecs)
.value(_.operating_system, entity.operatingSystem)
.value(_.browser, entity.browser)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, country : String, metric : Int) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, country : String, metric : Int, tensecsStart : DateTime, tensecsEnd : DateTime) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.metric eqs metric)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
  }
 def query(partnerId : Int, country : String, metric : Int, tensecsStart : DateTime, tensecsEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.metric eqs metric)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
.and(_.operating_system gte operatingSystemStart)
.and(_.operating_system lt operatingSystemEnd)
  }
 def query(partnerId : Int, country : String, metric : Int, tensecsStart : DateTime, tensecsEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int, browserStart : Int, browserEnd : Int) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.metric eqs metric)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
.and(_.operating_system gte operatingSystemStart)
.and(_.operating_system lt operatingSystemEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }
def query(partnerIdList : List[Int], countryList : List[String], metricList : List[Int]) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], countryList : List[String], metricList : List[Int], tensecsStart : DateTime, tensecsEnd : DateTime) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.metric in metricList)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
  }
 def query(partnerIdList : List[Int], countryList : List[String], metricList : List[Int], tensecsStart : DateTime, tensecsEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.metric in metricList)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
.and(_.operating_system gte operatingSystemStart)
.and(_.operating_system lt operatingSystemEnd)
  }
 def query(partnerIdList : List[Int], countryList : List[String], metricList : List[Int], tensecsStart : DateTime, tensecsEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int, browserStart : Int, browserEnd : Int) : SelectQuery[TensecsUaPrtnCountryClstOsBrowserTableAccessor, TensecsUaPrtnCountryClstOsBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.metric in metricList)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
.and(_.operating_system gte operatingSystemStart)
.and(_.operating_system lt operatingSystemEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }

}
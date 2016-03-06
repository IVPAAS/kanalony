package kanalony.storage.logic.queries

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class hourly_ua_prtn_entry_os_browserQuery extends QueryBase[hourly_ua_prtn_entry_os_browserQueryParams, hourly_ua_prtn_entry_os_browserRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): hourly_ua_prtn_entry_os_browserQueryParams = {
        val (partner_id,entry_id,operating_system,browser) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,Int,Int]((Dimensions.partner,Dimensions.entry,Dimensions.operatingSystem,Dimensions.browser), params)
        hourly_ua_prtn_entry_os_browserQueryParams(params.start, params.end, partner_id,entry_id,operating_system,browser, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: hourly_ua_prtn_entry_os_browserQueryParams): Future[List[hourly_ua_prtn_entry_os_browserRow]] = {
        val rawQueryResult = hourly_ua_prtn_entry_os_browserTableAccessor.query(params.partner_id_list,params.entry_id_list,params.operating_system_list,params.browser_list,params.metric_list,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.operatingSystem.toString,Dimensions.browser.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: hourly_ua_prtn_entry_os_browserRow): List[String] = {
        List(row.partner_id.toString,row.entry_id.toString,row.operating_system.toString,row.browser.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: hourly_ua_prtn_entry_os_browserRow): Int = row.metric
    }

case class hourly_ua_prtn_entry_os_browserQueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], entry_id_list : List[String], operating_system_list : List[Int], browser_list : List[Int], metric_list : List[Int]) extends IYearlyPartitionedQueryParams
package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyUaPrtnEntryCv1ClstCv2Query extends QueryBase[HourlyUaPrtnEntryCv1ClstCv2QueryParams, HourlyUaPrtnEntryCv1ClstCv2Row] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyUaPrtnEntryCv1ClstCv2QueryParams = {
        val (partner_id,entry_id,custom_var1) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.cf1), params)
        HourlyUaPrtnEntryCv1ClstCv2QueryParams(params.start, params.end, partner_id,entry_id,custom_var1, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: HourlyUaPrtnEntryCv1ClstCv2QueryParams): Future[List[HourlyUaPrtnEntryCv1ClstCv2Row]] = {
        val rawQueryResult = HourlyUaPrtnEntryCv1ClstCv2TableAccessor.query(params.partnerIdList,params.entryIdList,params.customVar1List,params.years,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.cf1.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.cf2.toString,"value")
      }

      override protected def getResultRow(row: HourlyUaPrtnEntryCv1ClstCv2Row): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.customVar1.toString,row.metric.toString,row.hour.toString,row.customVar2.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf1, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.cf2, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: HourlyUaPrtnEntryCv1ClstCv2Row): Int = row.metric
    }

case class HourlyUaPrtnEntryCv1ClstCv2QueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], customVar1List : List[String], metricList : List[Int]) extends IYearlyPartitionedQueryParams
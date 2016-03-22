package kanalony.storage.generator

/**
 * Created by elad.benedict on 2/8/2016.
 */

object TablesMetadata {
  def metadata = List(
    createTableMetadata("hourly_ua_prtn_entry", "((partner,entry,metric,month),hour),value"),
    createTableMetadata("minutely_ua_", "((partner,metric),minute),value"),
    createTableMetadata("hourly_ua_", "((partner,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry", "((partner,entry,day,metric),minute),value"),
    createTableMetadata("minutely_ua_clst_entry", "((partner,day,metric),minute,entry),value"),
    createTableMetadata("hourly_ua_clst_entry", "((partner,metric,month),hour,entry),value"),
    createTableMetadata("minutely_ua_clst_country", "((partner,metric),minute,country),value"),
    createTableMetadata("hourly_ua_clst_country", "((partner,metric,year),hour,country),value"),
    createTableMetadata("minutely_ua_prtn_country", "((partner,country,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_country", "((partner,country,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_country", "((partner,entry,metric),minute,country),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_country", "((partner,entry,metric,year),hour,country),value"),
    createTableMetadata("minutely_ua_prtn_entry_country", "((partner,entry,country,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_country", "((partner,entry,country,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_country_city", "((partner,metric),minute,country,city),value"),
    createTableMetadata("hourly_ua_clst_country_city", "((partner,metric,year),hour,country,city),value"),
    createTableMetadata("minutely_ua_prtn_country_city", "((partner,country,city,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_country_city", "((partner,country,city,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_country_city", "((partner,entry,metric),minute,country,city),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_country_city", "((partner,entry,metric,year),hour,country,city),value"),
    createTableMetadata("minutely_ua_prtn_entry_country_city", "((partner,entry,country,city,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_country_city", "((partner,entry,country,city,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_device", "((partner,metric),minute,device),value"),
    createTableMetadata("hourly_ua_clst_device", "((partner,metric,year),hour,device),value"),
    createTableMetadata("minutely_ua_prtn_device", "((partner,device,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_device", "((partner,device,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_device", "((partner,entry,metric),minute,device),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_device", "((partner,entry,metric,year),hour,device),value"),
    createTableMetadata("minutely_ua_prtn_entry_device", "((partner,entry,device,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_device", "((partner,entry,device,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_os", "((partner,metric),minute,os),value"),
    createTableMetadata("hourly_ua_clst_os", "((partner,metric,year),hour,os),value"),
    createTableMetadata("minutely_ua_prtn_os", "((partner,os,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_os", "((partner,os,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_os", "((partner,entry,metric),minute,os),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_os", "((partner,entry,metric,year),hour,os),value"),
    createTableMetadata("minutely_ua_prtn_entry_os", "((partner,entry,os,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_os", "((partner,entry,os,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_browser", "((partner,metric),minute,browser),value"),
    createTableMetadata("hourly_ua_clst_browser", "((partner,metric,year),hour,browser),value"),
    createTableMetadata("minutely_ua_prtn_browser", "((partner,browser,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_browser", "((partner,browser,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_browser", "((partner,entry,metric),minute,browser),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_browser", "((partner,entry,metric,year),hour,browser),value"),
    createTableMetadata("minutely_ua_prtn_entry_browser", "((partner,entry,browser,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_browser", "((partner,entry,browser,metric,year),hour),value"),
    createTableMetadata("minutely_ua_ptrn_device_clst_os", "((partner,device,metric),minute,os),value"),
    createTableMetadata("hourly_ua_ptrn_device_clst_os", "((partner,device,metric,year),hour,os),value"),
    createTableMetadata("minutely_ua_prtn_device_os", "((partner,device,os,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_device_os", "((partner,device,os,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_device_clst_os", "((partner,entry,device,metric),minute,os),value"),
    createTableMetadata("hourly_ua_prtn_entry_device_clst_os", "((partner,entry,device,metric,year),hour,os),value"),
    createTableMetadata("minutely_ua_prtn_entry_device_os", "((partner,entry,device,os,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_device_os", "((partner,entry,device,os,metric,year),hour),value"),
    createTableMetadata("minutely_ua_ptrn_os_clst_browser", "((partner,os,metric),minute,browser),value"),
    createTableMetadata("hourly_ua_ptrn_os_clst_browser", "((partner,os,metric,year),hour,browser),value"),
    createTableMetadata("minutely_ua_prtn_os_browser", "((partner,os,browser,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_os_browser", "((partner,os,browser,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_os_clst_browser", "((partner,entry,os,metric),minute,browser),value"),
    createTableMetadata("hourly_ua_prtn_entry_os_clst_browser", "((partner,entry,os,metric,year),hour,browser),value"),
    createTableMetadata("minutely_ua_prtn_entry_os_browser", "((partner,entry,os,browser,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_os_browser", "((partner,entry,os,browser,metric,year),hour),value"),
    createTableMetadata("hourly_ua_prtn_country_clst_os_browser", "((partner,country,metric,year),hour,os,browser),value"),
    createTableMetadata("hourly_ua_prtn_country_clst_os", "((partner,country,metric,year),hour,os),value"),
    createTableMetadata("hourly_ua_prtn_country_clst_browser", "((partner,country,metric,year),hour,browser),value"),
    createTableMetadata("minutely_ua_clst_domain", "((partner,metric),minute,domain),value"),
    createTableMetadata("hourly_ua_clst_domain", "((partner,metric,year),hour,domain),value"),
    createTableMetadata("minutely_ua_prtn_domain", "((partner,domain,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_domain", "((partner,domain,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_domain", "((partner,entry,metric),minute,domain),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_domain", "((partner,entry,metric,year),hour,domain),value"),
    createTableMetadata("minutely_ua_prtn_entry_domain", "((partner,entry,domain,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_domain", "((partner,entry,domain,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_referrer", "((partner,metric),minute,referrer),value"),
    createTableMetadata("hourly_ua_clst_referrer", "((partner,metric,year),hour,referrer),value"),
    createTableMetadata("minutely_ua_prtn_referrer", "((partner,referrer,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_referrer", "((partner,referrer,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_referrer", "((partner,entry,metric),minute,referrer),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_referrer", "((partner,entry,metric,year),hour,referrer),value"),
    createTableMetadata("minutely_ua_prtn_entry_referrer", "((partner,entry,referrer,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_referrer", "((partner,entry,referrer,metric,year),hour),value"),
    createTableMetadata("minutely_ua_ptrn_domain_clst_referrer", "((partner,domain,metric),minute,referrer),value"),
    createTableMetadata("hourly_ua_ptrn_domain_clst_referrer", "((partner,domain,metric,year),hour,referrer),value"),
    createTableMetadata("minutely_ua_prtn_entry_domain_clst_referrer", "((partner,entry,domain,metric),minute,referrer),value"),
    createTableMetadata("hourly_ua_prtn_entry_domain_clst_referrer", "((partner,entry,domain,metric,year),hour,referrer),value"),
    createTableMetadata("minutely_ua_clst_app", "((partner,metric),minute,application),value"),
    createTableMetadata("hourly_ua_clst_app", "((partner,metric,year),hour,application),value"),
    createTableMetadata("minutely_ua_prtn_app", "((partner,application,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_app", "((partner,application,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_app", "((partner,entry,metric),minute,application),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_app", "((partner,entry,metric,year),hour,application),value"),
    createTableMetadata("minutely_ua_prtn_entry_app", "((partner,entry,application,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_app", "((partner,entry,application,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_playback_context", "((partner,metric),minute,playback_context),value"),
    createTableMetadata("hourly_ua_clst_playback_context", "((partner,metric,year),hour,playback_context),value"),
    createTableMetadata("minutely_ua_prtn_playback_context", "((partner,playback_context,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_playback_context", "((partner,playback_context,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_playback_context", "((partner,entry,metric),minute,playback_context),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_playback_context", "((partner,entry,metric,year),hour,playback_context),value"),
    createTableMetadata("minutely_ua_prtn_entry_playback_context", "((partner,entry,playback_context,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_playback_context", "((partner,entry,playback_context,metric,year),hour),value"),
    createTableMetadata("minutely_ua_ptrn_app_clst_playback_context", "((partner,application,metric),minute,playback_context),value"),
    createTableMetadata("hourly_ua_ptrn_app_clst_playback_context", "((partner,application,metric,year),hour,playback_context),value"),
    createTableMetadata("minutely_ua_prtn_app_playback_context", "((partner,application,playback_context,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_app_playback_context", "((partner,application,playback_context,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_app_clst_playback_context", "((partner,entry,application,year),minute,playback_context),value"),
    createTableMetadata("hourly_ua_prtn_entry_app_clst_playback_context", "((partner,entry,application,metric,year),hour,playback_context),value"),
    createTableMetadata("minutely_ua_prtn_entry_app_playback_context", "((partner,entry,application,playback_context,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_app_playback_context", "((partner,entry,application,playback_context,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_cv1", "((partner,metric),minute,custom_var1),value"),
    createTableMetadata("hourly_ua_clst_cv1", "((partner,metric,year),hour,custom_var1),value"),
    createTableMetadata("minutely_ua_prtn_cv1", "((partner,custom_var1,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_cv1", "((partner,custom_var1,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_cv1", "((partner,entry,metric),minute,custom_var1),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_cv1", "((partner,entry,metric,year),hour,custom_var1),value"),
    createTableMetadata("minutely_ua_prtn_entry_cv1", "((partner,entry,custom_var1,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_cv1", "((partner,entry,custom_var1,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_cv2", "((partner,metric),minute,custom_var2),value"),
    createTableMetadata("hourly_ua_clst_cv2", "((partner,metric,year),hour,custom_var2),value"),
    createTableMetadata("minutely_ua_prtn_cv2", "((partner,custom_var2,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_cv2", "((partner,custom_var2,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_cv2", "((partner,entry,metric),minute,custom_var2),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_cv2", "((partner,entry,metric,year),hour,custom_var2),value"),
    createTableMetadata("minutely_ua_prtn_entry_cv2", "((partner,entry,custom_var2,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_cv2", "((partner,entry,custom_var2,metric,year),hour),value"),
    createTableMetadata("minutely_ua_clst_cv3", "((partner,metric),minute,custom_var3),value"),
    createTableMetadata("hourly_ua_clst_cv3", "((partner,metric,year),hour,custom_var3),value"),
    createTableMetadata("minutely_ua_prtn_cv3", "((partner,custom_var3,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_cv3", "((partner,custom_var3,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_clst_cv3", "((partner,entry,metric),minute,custom_var3),value"),
    createTableMetadata("hourly_ua_prtn_entry_clst_cv3", "((partner,entry,metric,year),hour,custom_var3),value"),
    createTableMetadata("minutely_ua_prtn_entry_cv3", "((partner,entry,custom_var3,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_cv3", "((partner,entry,custom_var3,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_cv1_clst_cv2", "((partner,custom_var1,metric),minute,custom_var2),value"),
    createTableMetadata("hourly_ua_prtn_cv1_clst_cv2", "((partner,custom_var1,metric,year),hour,custom_var2),value"),
    createTableMetadata("minutely_ua_prtn_cv1_cv2", "((partner,custom_var1,custom_var2,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_cv1_cv2", "((partner,custom_var1,custom_var2,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_cv1_clst_cv2", "((partner,entry,custom_var1,metric),minute,custom_var2),value"),
    createTableMetadata("hourly_ua_prtn_entry_cv1_clst_cv2", "((partner,entry,custom_var1,metric,year),hour,custom_var2),value"),
    createTableMetadata("minutely_ua_prtn_entry_cv1_cv2", "((partner,entry,custom_var1,custom_var2,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_cv1_cv2", "((partner,entry,custom_var1,custom_var2,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_cv1_cv2_clst_cv3", "((partner,custom_var1,custom_var2,metric),minute,custom_var3),value"),
    createTableMetadata("hourly_ua_prtn_cv1_cv2_clst_cv3", "((partner,custom_var1,custom_var2,metric,year),hour,custom_var3),value"),
    createTableMetadata("minutely_ua_prtn_cv1_cv2_cv3", "((partner,custom_var1,custom_var2,custom_var3,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_cv1_cv2_cv3", "((partner,custom_var1,custom_var2,custom_var3,metric,year),hour),value"),
    createTableMetadata("minutely_ua_prtn_entry_cv1_cv2_clst_cv3", "((partner,entry,custom_var1,custom_var2,metric),minute,custom_var3),value"),
    createTableMetadata("hourly_ua_prtn_entry_cv1_cv2_clst_cv3", "((partner,entry,custom_var1,custom_var2,metric,year),hour,custom_var3),value"),
    createTableMetadata("minutely_ua_prtn_entry_cv1_cv2_cv3", "((partner,entry,custom_var1,custom_var2,custom_var3,metric),minute),value"),
    createTableMetadata("hourly_ua_prtn_entry_cv1_cv2_cv3", "((partner,entry,custom_var1,custom_var2,custom_var3,metric,year),hour),value")
  )

  def createColumnDefinition(s: String, isInPartitionKey : Boolean, isInClusteringKey : Boolean): IColumnDefinition = s match {
    case "partner" => ColumnDefinition(ColumnNames.partner_id, ColumnType.Int, isInPartitionKey, isInClusteringKey)
    case "entry" => ColumnDefinition(ColumnNames.entry_id, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "metric" => ColumnDefinition(ColumnNames.metric, ColumnType.Int, isInPartitionKey, isInClusteringKey)
    case "year" => ColumnDefinition(ColumnNames.year, ColumnType.Int, isInPartitionKey, isInClusteringKey)
    case "month" => ColumnDefinition(ColumnNames.month, ColumnType.Int, isInPartitionKey, isInClusteringKey)
    case "country" => ColumnDefinition(ColumnNames.country, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "city" => ColumnDefinition(ColumnNames.city, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "os" => ColumnDefinition(ColumnNames.operating_system, ColumnType.Int, isInPartitionKey, isInClusteringKey)
    case "browser" => ColumnDefinition(ColumnNames.browser, ColumnType.Int, isInPartitionKey, isInClusteringKey)
    case "device" => ColumnDefinition(ColumnNames.device, ColumnType.Int, isInPartitionKey, isInClusteringKey)
    case "domain" => ColumnDefinition(ColumnNames.domain, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "referrer" => ColumnDefinition(ColumnNames.referrer, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "application" => ColumnDefinition(ColumnNames.application, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "cf1" => ColumnDefinition(ColumnNames.cf1, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "cf2" => ColumnDefinition(ColumnNames.cf2, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "cf3" => ColumnDefinition(ColumnNames.cf3, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "playbackContext" => ColumnDefinition(ColumnNames.playbackContext, ColumnType.String, isInPartitionKey, isInClusteringKey)
    case "value" => ColumnDefinition(ColumnNames.value, ColumnType.Long, isInPartitionKey, isInClusteringKey)
  }

  def createClusteringColumnDefinition(s: String): IClusteringColumnDefinition = s match {
    case "hour" => ClusteringColumnDefinition(ColumnNames.hour, ColumnType.DateTime, OrderBy.Descending)
    case "minute" => ClusteringColumnDefinition(ColumnNames.minute, ColumnType.DateTime, OrderBy.Descending)
    case "entry" => ClusteringColumnDefinition(ColumnNames.entry_id, ColumnType.String)
    case "country" => ClusteringColumnDefinition(ColumnNames.country, ColumnType.String)
    case "city" => ClusteringColumnDefinition(ColumnNames.city, ColumnType.String)
    case "device" => ClusteringColumnDefinition(ColumnNames.device, ColumnType.Int)
    case "browser" => ClusteringColumnDefinition(ColumnNames.browser, ColumnType.Int)
    case "os" => ClusteringColumnDefinition(ColumnNames.operating_system, ColumnType.Int)
    case "domain" => ClusteringColumnDefinition(ColumnNames.domain, ColumnType.String)
    case "referrer" => ClusteringColumnDefinition(ColumnNames.referrer, ColumnType.String)
    case "application" => ClusteringColumnDefinition(ColumnNames.application, ColumnType.String)
    case "playbackContext" => ClusteringColumnDefinition(ColumnNames.playbackContext, ColumnType.String)
    case "cf1" => ClusteringColumnDefinition(ColumnNames.cf1, ColumnType.String)
    case "cf2" => ClusteringColumnDefinition(ColumnNames.cf2, ColumnType.String)
    case "cf3" => ClusteringColumnDefinition(ColumnNames.cf3, ColumnType.String)
  }

  def createPartitionKey(partitionKeyColumns: String) : PartitionKey = {
    PartitionKey(partitionKeyColumns.split(",").map(createColumnDefinition(_, true, false)).toList)
  }

  def createClusteringKey(clusteringColumns: String) : ClusteringKey = {
    ClusteringKey(clusteringColumns.split(",").map(createClusteringColumnDefinition(_)).toList)
  }

  def createAdditionalColumns(additionalColumns: String) : List[IColumnDefinition] = {
    additionalColumns.split(",").map(createColumnDefinition(_, false, false)).toList
  }

  def createTableMetadata(tableName : String, tableMetadata : String) : TableMetadata = {
    val tableMetadataPattern = """\(\((.*)\),?(.*)\),?(.*)""".r
    tableMetadata match {
      case tableMetadataPattern(partitionKeyColumns, clusteringColumns, additionalColumns) => {
        val partitionKey = createPartitionKey(partitionKeyColumns)
        val clusteringKey = createClusteringKey(clusteringColumns)
        val primaryKey = PrimaryKey(partitionKey, clusteringKey)
        val additionalCols = createAdditionalColumns(additionalColumns)
        TableMetadata(tableName, primaryKey, additionalCols)
      }
    }
  }
}

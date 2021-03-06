package kanalony.storage.generator

import com.google.common.base.CaseFormat
import kanalony.storage.generator.GenerationTemplates.{tableAccessorInterfaceTemplate, partitionKeyColumnDefinitionTemplate, clusteringKeyColumnDefinitionTemplate}

/**
 * Created by elad.benedict on 2/8/2016.
 */
class TableAccessorGenerator(val tm : TableMetadata) {

  private def generateClassName(): String = {
    return TableAccessorGenerator.generateClassName(tm)
  }

  private def generateEntityClassName(): String = {
    EntityClassGenerator.getEntityName(tm)
  }

  private def generateValuePopulation(): String = {
    var res = "";
    val columns = tm.columns
    for (c <- columns){
      var valueAssignment = GenerationTemplates.valueDefinitionTemplate.content
      valueAssignment = valueAssignment.replace(GenerationTemplates.valueDefinitionTemplate.propertyNamePlaceholder, c.name.toString)
      valueAssignment = valueAssignment.replace(GenerationTemplates.valueDefinitionTemplate.paramNamePlaceholder, EntityClassGenerator.getParamName(c.name))
      res = res + valueAssignment + "\n"
    }
    res
  }

  private def generateTableName() = tm.tableName

  private def generateColumnDefs[T <: IColumnDefinition](colDefs : List[T], templateCreator : T => IColumnDefinitionTemplate) : String = {
    var res = "";
    for (colDef <- colDefs){
      val colDefTemplate = templateCreator(colDef)
      val colDefResult = colDefTemplate.content.replace(colDefTemplate.propNamePlaceholder, colDef.name.toString)
        .replace(colDefTemplate.typePlaceholder, colDef.typeName.toString)
      res = res + colDefResult + "\n"
    }
    res
  }

  private def generatePartitionKeyDefs(colDefs : List[IColumnDefinition]) : String = {
    generateColumnDefs[IColumnDefinition](colDefs, c => new partitionKeyColumnDefinitionTemplate())
  }

  private def generateAdditionalColumnsDefs(colDefs : List[IColumnDefinition]) : String = {
    generateColumnDefs[IColumnDefinition](colDefs, c => new GenerationTemplates.columnDefinitionTemplate())
  }

  private def generateClusteringKeyDefs(colDefs : List[IClusteringColumnDefinition]) : String = {
    generateColumnDefs[IClusteringColumnDefinition](colDefs, c => new GenerationTemplates.clusteringKeyColumnDefinitionTemplate(c.orderBy))
  }

  private def generateTableColDefs(): String = {
    var generatedContent = ""
    generatedContent = generatedContent + generatePartitionKeyDefs(tm.primaryKey.pk.columns)
    generatedContent = generatedContent + generateClusteringKeyDefs(tm.primaryKey.ck.columns)
    generatedContent = generatedContent + generateAdditionalColumnsDefs(tm.additionalColumns)
    generatedContent
  }

  private def generateRowDecomposition() : String = generateRowDecomposition(tm.columns)

  private def generateRowDecomposition(cols : List[IColumnDefinition]) = {
    cols.map(x => GenerationTemplates.propertyDecompositionTemplate.content.replace(GenerationTemplates.propertyDecompositionTemplate.propNamePlaceholder, x.name.toString))
        .mkString(", \n")
  }

  private def generateQueryMethods(pkSingleValueEquality : Boolean, signatureOnly : Boolean) : String = {
    val methodGenerator = new QueryMethodsGenerator(tm)
    val queryGenerator = if (signatureOnly) { methodGenerator.generateQueryMethodSignature(_) } else { methodGenerator.generateQueryMethod(_) }

    val pkColumnQueryKind = if (pkSingleValueEquality) ColumnQueryKind.Equality else ColumnQueryKind.List
    val partitionKeyQueryColumnDefs = tm.primaryKey.pk.columns.map(x => new QueryableColumnDefinition(x.name, x.typeName, pkColumnQueryKind, true, false))
    var generatedQueries = queryGenerator(partitionKeyQueryColumnDefs);

    val clusteringQueryColumnDefs = tm.primaryKey.ck.columns.map(x => new QueryableColumnDefinition(x.name, x.typeName, ColumnQueryKind.Range, false, true))
    for( i <- 1 to clusteringQueryColumnDefs.length) {
      generatedQueries = generatedQueries + "\n " + queryGenerator(partitionKeyQueryColumnDefs ::: clusteringQueryColumnDefs.take(i))
    }

    generatedQueries
  }

  def generateIntrefaceName() = TableAccessorGenerator.generateInterfaceName(tm)

  def generateInterface() : String  = {
    var queryMethodsSignatures = generateQueryMethods(true, true)
    queryMethodsSignatures = queryMethodsSignatures + "\n" + generateQueryMethods(false, true)
    tableAccessorInterfaceTemplate.content
      .replace(tableAccessorInterfaceTemplate.queryMethodsSignaturesPlaceholder, queryMethodsSignatures)
      .replace(tableAccessorInterfaceTemplate.tableAccessorInterfaceNamePlaceholder, generateIntrefaceName())
  }

  def generate() = {
    var generatedContent = GenerationTemplates.packageTemplate.content + "\n";
    val tableAccessorTemplate = GenerationTemplates.tableAccessorTemplate;
    generatedContent = generatedContent + tableAccessorTemplate.content

    generatedContent = generatedContent.replace(tableAccessorTemplate.classNamePlaceholder, generateClassName())
    generatedContent = generatedContent.replace(tableAccessorTemplate.interfaceNamePlaceholder, generateIntrefaceName())
    generatedContent = generatedContent.replace(tableAccessorTemplate.entityClassNamePlaceholder, generateEntityClassName())
    generatedContent = generatedContent.replace(tableAccessorTemplate.valuePopulationPlaceholder, generateValuePopulation())
    generatedContent = generatedContent.replace(tableAccessorTemplate.rowDecompositionPlaceholder, generateRowDecomposition())
    generatedContent = generatedContent.replace(tableAccessorTemplate.tableColDefsPlaceholder, generateTableColDefs())
    generatedContent = generatedContent.replace(tableAccessorTemplate.tableNamePlaceholder, generateTableName())
    var queryMethods = generateQueryMethods(true, false)
    queryMethods = queryMethods + "\n" + generateQueryMethods(false, false)
    generatedContent = generatedContent.replace(tableAccessorTemplate.queryMethodsPlaceholder, queryMethods)

    generatedContent
  }
}

object TableAccessorGenerator{
  def generateClassName(tm : TableMetadata): String = {
    CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tm.tableName) + "TableAccessor"
  }

  def generateInterfaceName(tm : TableMetadata) : String = {
    s"I${generateClassName(tm)}"
  }
}

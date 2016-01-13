# gah-alert-definitions
Load predefined definitions into JON

## Based on
https://github.com/rhq-project/rhq/tree/master/modules/enterprise/server/plugins/alertdef-rhq

## How to create a new alert
If you are not sure what the 'pluginName' or 'resourceTypeName' for the InjectedTemplate is, follow the below:
- Create via GUI in JON
- Execute below SQL
  - export PGPASSWORD=rhqadmin && psql -U rhqadmin -d rhq

  - select ad.name as alert_name, rt.plugin as plugin_name, rt.name as resource_type_name,
    ac.name as alert_name, ac.type as alert_category, ac.comparator as alert_comparator, ac.threshold as alert_threshold, md.name as measurement_name
    from rhq_alert_definition ad
    left join rhq_resource_type rt ON ad.resource_type_id = rt.id
    left join rhq_alert_condition ac ON ad.id = ac.alert_definition_id
    left join rhq_measurement_def md ON ac.measurement_definition_id = md.id
    where ad.parent_id = 0 and ad.name = '{alert name}'
    order by ad.name asc;

## Important tables
- rhq_alert_definition
- rhq_resource_type
- rhq_measurement_def
- rhq_alert_condition

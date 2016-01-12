# gah-alert-definitions
Load predefined definitions into JON

## Based on
https://github.com/rhq-project/rhq/tree/master/modules/enterprise/server/plugins/alertdef-rhq

## How to create a new alert
If you are not sure what the 'pluginName' or 'resourceTypeName' for the InjectedTemplate is, follow the below:
- Create via GUI in JON
- Execute below SQL
  - export PGPASSWORD=rhqadmin && psql -U rhqadmin -d rhq
  - select ad.id from rhq_alert_definition ad
    where ad.name = '{alert name created}';
  - select ad.name, rt.plugin, rt.name, md.name from rhq_alert_definition ad
    join rhq_resource_type rt ON ad.resource_type_id = rt.id
    join rhq_measurement_def md ON ad.resource_type_id = md.resource_type_id;
    where ad.id = {id returned from above}
    order by ad.name asc;

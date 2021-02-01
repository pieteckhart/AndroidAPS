# Azure Devops Pipelines
The [azure-pipelines.yml](azure-pipelines.yml) script can be used to build AndroidAPS inside a Azure Devops Pipeline

![build status](https://dev.azure.com/pieteckhart/AndroidAPS/_apis/build/status/pieteckhart.AndroidAPS?branchName=master "My private build")

## Configuration
The script assumes that you have a variable group named '`keystore-group`' in your pipeline library containing these variables:
- KeyPassword
- KeystorePassword
- KeystoreAlias

The keystore file must be named '`keystore.jks`' and also be added to the library as a secure file.

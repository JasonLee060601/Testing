@Library('jenkins-shared-library@master') _

buildPipeline {
    projectType = 'web-api'
    projectName = 'testing-playground'
    gitRepoUrl = 'https://github.com/JasonLee060601/Testing.git'
    projectFolder = 'TestingPlayground.API'
    kubernetesNamespace = 'backend-team'
    isConfigMapsEnabled = true
    propRegex = '^1 tag_push testing-playground/(\\d+\\.){3}\\d+(-.+)?$'
    helmFile = [
        common: """image: REPLACE_IMAGE
appType: web-api
appEnv:
  ASPNETCORE_URLS: http://0.0.0.0:80;http://0.0.0.0:12345
service:
  enabled: true
  port: 80
  protocol: http
gateway:
  enabled: true
  path: /web-api/testing-playground/
"""
    ]
}

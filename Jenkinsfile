pipeline {
  agent none
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Verifica Workspace') {
      steps {
        fileExists '/var/lib/docker/volumes/jenkins_home/_data/workspace/api-spotippos*'
      }
    }
  }
}
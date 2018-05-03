pipeline {
  agent none
  stages {
    stage('Initialize') {
      steps {
        echo 'Iniciando Pipeline'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true clean install'
      }
    }
  }
}
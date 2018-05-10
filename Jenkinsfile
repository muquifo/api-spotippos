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
        sh 'mvn clean install'
      }
    }
    stage('Teste') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
}
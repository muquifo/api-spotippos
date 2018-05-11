pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'Iniciando Pipeline'
      }
    }
    stage('Build') {
      steps {
        echo 'Iniciando Build'
        sh 'mvn clean package'
      }
    }
    stage('Teste') {
      steps {
        echo 'Iniciando TESTE'
        withMaven(maven: 'maven', mavenSettingsConfig: 'maven-conf') {
          sh 'mvn clean test'
        }
        
      }
    }
  }
  environment {
    agent = 'master'
  }
}
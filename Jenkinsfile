pipeline {
  agent {label 'master'}

  stages {
    stage('Initialize') {
      steps {
        echo 'Iniciando Pipeline'
      }
    }
    stage('Build') {
		steps {
			withMaven(maven: 'maven', mavenSettingsConfig: 'maven-conf') {
				sh 'mvn clean package'
			}
		}
	}
    stage('Teste') {
		steps {
        	withMaven(maven: 'maven', mavenSettingsConfig: 'maven-conf') {
				sh 'mvn clean test'
			}
      	}
    }
  }
}
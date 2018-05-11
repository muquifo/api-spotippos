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
			dir('api') {
				echo 'Iniciando BUILD'
				withMaven(maven: 'maven', mavenSettingsConfig: 'maven-conf') {
					sh 'mvn clean package'
				}
			}
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
}
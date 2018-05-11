pipeline {
  stages {
    stage('Initialize') {
      steps {
        echo 'Iniciando Pipeline'
      }
    }
    stage('Build') {
      steps {
        echo 'Iniciando Build'
        withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: 'maven',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
        mavenSettingsConfig: 'maven-conf') {
 
      	sh "mvn clean package"
 
    	} // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
      }
    }
    stage('Teste') {
      steps {
        echo 'Iniciando TESTE'
         withMaven(aven: 'maven',mavenSettingsConfig: 'maven-conf') {
      		sh "mvn test"
    	}
        
      }
    }
  }
  environment {
    agent = 'master'
  }
}
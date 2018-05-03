pipeline {
  agent {
    docker {
      args '-v /home/murilo/java/.m2:/root/.m2'
      image 'maven'
    }
    
  }
  stages {
    stage('Initialize') {
      steps {
        sh '''echo PATH = ${PATH}
echo M2_HOME = ${M2_HOME}
mvn clean'''
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
    stage('Report') {
      steps {
        junit 'target/**/*.xml'
        archiveArtifacts 'target/*.jar.target/*.hpi'
      }
    }
  }
}
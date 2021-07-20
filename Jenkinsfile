pipeline {
  agent any
  tools {
    maven 'Maven'
  }
  stages {
    stage ('Initialize') {
      steps {
        bat '''
                echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
           '''
      }
    }
    stage ('Build') {
      steps {
        bat 'mvn clean package'
      }
    }
    stage('Deploy') { 
            steps {
                bat 'xcopy /f C:/Windows/System32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/demo-project/target/SpringMVC.war F:/Software/jboss-eap/standalone/deployments/SpringMVC.war'
            }
        }
  }
}

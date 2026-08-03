pipeline { 
    agent any
    
     tools{
            maven "MAVEN_HOME"
     }
    stages 
    { 
        stage('Checkout') 
        { 
            steps 
            { 
                git 'git@github.com:Rani-Jadhav/TestNG_auto_fram1git.git' 
            }   
        } 
        stage('Run Automation')  
            { 
                    steps 
                    { 
                        bat 'mvn clean test' 
                    } 
                    
        } } 
                    
       post {
    always {
        junit '**/target/surefire-reports/*.xml'
        archiveArtifacts artifacts: 'test-output/**/*'
    }
}
    
}

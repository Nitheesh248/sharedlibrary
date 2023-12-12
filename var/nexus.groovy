
def call() {
    stage('nexus upload') {
        steps {
            script {
                def pom = readMavenPom file: 'pom.xml'
                def version = pom.version
                
                nexusArtifactUploader(
                    artifacts: [[artifactId: 'doctor-online', classifier: '', file: 'target/doctor-online.war', type: 'war']],
                    credentialsId: 'nexus3',
                    groupId: 'in.javahome',
                    nexusUrl: '172.31.37.204:8081',
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    repository: 'doctor-online',
                    version: version
                )
            }
        }
    }
}

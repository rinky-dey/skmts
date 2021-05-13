node{

  stage('SCM Config'){
   git 'https://github.com/rinky-dey/skmts'
  }
  stage('Compile-package'){
    def PATH+EXTRA = "/opt/blah/bin"  
   sh 'mvn package'
  }
}

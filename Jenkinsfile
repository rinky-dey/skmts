node{

  stage('SCM Config'){
   git 'https://github.com/rinky-dey/skmts'
  }
  stage('Compile-package'){
   sh 'mvn package'
  }
}

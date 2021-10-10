echo "Build project"
mvn clean install

# Args: 1-ProjectName, 2- ProjectVersion
function build() {
   docker build -t $1:$2 \
   -f example/Dockerfile $1 \
   --build-arg PROJECT_NAME=$1 \
   --build-arg PROJECT_VERSION=$2
}

echo "Build books-library image"
build books-library 1.0.0

echo "Build book-downloader image"
build book-downloader 1.0.0
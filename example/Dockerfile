FROM openjdk:8
RUN env
ARG PROJECT_NAME
ARG PROJECT_VERSION
ENV USER_INSTALL_HOME="/home"
ENV TARGET_JAR=$PROJECT_NAME-$PROJECT_VERSION.jar
RUN mkdir -p ${USER_INSTALL_HOME}/${PROJECT_NAME}
ENV PROJECT_DIR=${USER_INSTALL_HOME}/${PROJECT_NAME}
COPY target/$TARGET_JAR  ${PROJECT_DIR}/lib/$TARGET_JAR
WORKDIR ${PROJECT_DIR}/lib
RUN ls -R ${USER_INSTALL_HOME}
CMD java -jar ${TARGET_JAR}
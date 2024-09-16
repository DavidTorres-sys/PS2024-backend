FROM openjdk:17-jdk-slim

WORKDIR /app

# Install SBT
RUN apt-get update && apt-get install -y \
    curl \
    unzip \
    && curl -L https://github.com/sbt/sbt/releases/download/v1.8.0/sbt-1.8.0.zip -o sbt.zip \
    && unzip sbt.zip -d /usr/local/ \
    && ln -s /usr/local/sbt/bin/sbt /usr/local/bin/sbt

# Copy project files
COPY build.sbt /app/
COPY project /app/project/
COPY app /app/app/
COPY conf /app/conf/

# Build the application
RUN sbt stage

# Expose the port
EXPOSE 9000

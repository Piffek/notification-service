docker build -t notification-service:$1 .
docker tag notification-service:$1 piffek1/notification-service:$1
docker push piffek1/notification-service:$1

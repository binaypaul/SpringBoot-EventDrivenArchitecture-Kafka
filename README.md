# SpringBoot-EventDrivenArchitecture-Kafka
EventDrivenArchitecture for Spring Boot Microservices Application with Kafka
<p>-------------------------------------------------------------------------------------------------------</p>

* Order service produces order with status "CREATED" and sends to "order-topic" with 1 partition.
* Stock service with consumer group name "stock" consumes the event in "order-topic" (TODO: updates stock in db).
* Stock service then produces event for Notification service in topic "stock-topic" in 2 partitions (By mistake same message is sent to both partitions).
* Notification service with consumer group name "notification" consumes the event from both partitions, have added the set (ideally from db) logic to handle mistake of same message in both partitions.
<p>-------------------------------------------------------------------------------------------------------</p>

** Kafka performance tuning: https://www.redpanda.com/guides/kafka-performance
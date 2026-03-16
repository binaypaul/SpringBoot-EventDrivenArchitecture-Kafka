# SpringBoot-EventDrivenArchitecture-Kafka
EventDrivenArchitecture for Spring Boot Microservices Application with Kafka
<p>-------------------------------------------------------------------------------------------------------</p>

* Order service produces order with status "CREATED" and sends to "order-topic" with 1 partition.
* Stock service with consumer group name "stock" consumes the event in "order-topic" (TODO: updates stock in db).
* Stock service then produces event for Notification service in topic "stock-topic" in 2 partitions: 1 each for sms with key "SMS" and email with key "EMAIL".
* Notification service with consumer group name "sms" and "email" consumes the event in partitions with key "SMS" and "EMAIL" respectively.
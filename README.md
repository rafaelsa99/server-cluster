# Cluster of Servers
Practical assignment of the Software Architectures course of the Masters in Informatics Engineering of the University of Aveiro.

## Contextualization
Performance, Availability, Scalability and Usability are four of the most relevant Quality Attributes in most of the Software Architectures. The main goal of this assignment is the design and development of a platform the Software Architecture of which relies on those four Quality Attributes.

## Requirements
The stakeholder needs an infrastructure (cluster of servers) to provide its clients with mathematical computational services. For simplicity, the Avogadro Constant is the only computational service available: Na.
From the elected requirements, the following tactics were selected to be implemented to process the mathematical computations requests.

### Performance
- Replicas of computation: requests must be fairly distributed among the active servers;
- Concurrency:
  - each request runs on its own Thread in a single server;
  - each server accepts a maximum of 3 simultaneous running Threads
- Bound queue size: servers accept a maximum of 2 pending requests.

### Availability
- Redundancy: to reallocate requests delegated to a server in case it crashes;
- Monitor: to supervise the cluster’s status (up/down servers (heartbeat), clients: identification, pending requests, requests being processed, rejected requests, processed requests), etc., etc.).

### Scalability
- Horizontal scalability: add new servers whenever necessary.

### Usability
-All GUI must be driven by Usability for the EVALUATION PROCESS: usage, trace, verification, validation, etc. You can resort to the tactics and anything else you think is necessary. The stakeholder will use the GUI to validate your implementation.

## Constraints
- Define a Load-Balancer (LB) process comprising a GUI;
- Define a Monitor process comprising a GUI;
- Each server and each client must be implemented as a running process with a GUI;
- For simplicity, you can consider that all processes have 100% availability and no failures take place - unless they are intentionally killed/shut-down; only, the LB and the Monitor cannot be killed/shut-down;
- Requests: Clients -> LB -> Servers -> LB -> Clients; all communications are based on TCP/IP sockets.
- Each individual server can run a maximum of 3 simultaneously NA calculations (threads).
- Each individual server can queue (before being allocated to a thread) a maximum of 2 NA requests;
- For simplicity, consider that there is one type of request/service only (calculation of NA, Avogadro Constant):
  - request: | client id | request id | 00 | 01 | number of iterations | 0 |
  - reply: | client id | request id | server id | 02 | number of iterations | NA |
  - reply: | client id | request id | server id | 03 | number of iterations | 0 |

    - client id (Integer>0): unique identification for each client
    - request id (Integer>0): unique request identification = 1000*(client id) + increment
    - server id (Integer>0): unique identification for each server
    - 01 (Integer): request code for NA calculation
    - 02 (Integer): reply code for NA calculation
    - 03 (Integer): reply code for request rejection
    - number of iterations (NI, Integer>0): computation of NA takes 1 second for each iteration
    - NA (Double): value of NA – for simplicity, always 6.02214076 … x 10^23 (one decimal place by iteration, for example if NI = 4, NA = 6.0221 x 10^23)

## Use Cases
In order to evaluate the implementation, some use cases will be used. Hereafter, typical use cases are shown. You are encouraged to enhance each use case type to test your application with different values and contexts. 

<b>Use Case I</b> - evaluate if requests are fairly distributed across the cluster:
- Environment:
  - N running servers (N = 3)
- Stimulus:
  - M requests (M = 7, with enough NI)
- Expected response:
  - The replies show that the distribution was fair

<b>Use Case II</b> – evaluate if the cluster is scalable:
- Environment:
  - N running servers (N = 3)
  - M requests being computed (M = 7, with enough NI)
- Stimulus:
  - K new servers are added (K = 2)
  - P new requests are issued (P = 5, with enough NI)
- Expected response:
  - The replies show that the distribution was fair

<b>Use Case III</b> – evaluate if requests are processed in individual threads
- Environment:
  - N running servers (N = 1)
- Stimulus:
  - M requests are issued with enough specific decreasing NI (M = 3, with enough NI)
- Expected response:
  - The replies show that the requests were computed by concurrent threads

<b>Use Case IV</b> – evaluate maximum simultaneous Threads and queue size
- Environment:
  - N running servers (N=1)
- Stimulus:
  - M requests are issued (M = 7, with enough NI)
- Expected response:
  - Maximum 3 simultaneous computations
  - Maximum 2 queued requests
  - Last 2 requests are rejected

<b>Use Case V</b> – evaluate availability
- Environment:
  - N running servers (N=3)
  - M requests being processed (M = 7, with sufficient NI)
- Stimulus:
  - One server is shut down
- Expected result:
  - The requests running on the shut-down server must be fairly distributed among the other N-1 servers

<b>Use Case VI</b> – GUI evaluation

Each GUI will be evaluated in order to check its state and the information it shows in each use case
- LB
  - Interface to configure the LB
  - Be ambitious, improve the GUI of your LB
- Monitor
  - Interface to configure the Monitor
  - Interface to show the requests being managed by the LB
  - Interface to show the state of all requests being processed by each server
  - Interface to show the state of all servers (UP/DOWN)
  - Be ambitious, improve the GUI of your Monitor
- Server:
  - Interface to configure the server
  - Interface to show the details of all requests received
  - Interface to show the details of all processed requests
  - Be ambitious, improve the GUI of your servers
- Client:
  - Interface to configure the client
  - Interface to create new requests
  - Interface to show the pending requests (pending requests >=0)
  - Interface to show the executed requests
  - Be ambitious, improve the GUI of your clients

## Execution
To start the cluster, just run the Control Panel, and from there you can launch and manage all the entities in the cluster. It is also possible to start each entity individually.
### Control Panel
```
java -cp dist/PA3_G9.jar ControlPanel.ControlPanel_GUI
```
### Load Balancer
```
java -cp dist/PA3_G9.jar Configurations.LBConfiguration
```
### Monitor
```
java -cp dist/PA3_G9.jar Configurations.MonitorConfiguration
```
### Server
Parameters: 
- serverID: integer that uniquely identifies the server.
```
java -cp dist/PA3_G9.jar Configurations.ServerConfiguration 1
```
### Client
Parameters: 
- clientID: integer that uniquely identifies the client.
```
java -cp dist/PA3_G9.jar Configurations.ClientConfiguration 1
```

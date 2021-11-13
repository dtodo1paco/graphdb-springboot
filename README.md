# Welcome to the Springboot for neo4j Graphdb PoC 👋
> This is a PoC (Proof of Concept) of how to connect Springboot with a Neo4j Graph database. To illustrate how it can work, I've solved some of the exercices in the <i>"Neo4j: GraphDB Foundations with Cypher
"</i> Udemy course 
<p>
  <img src="https://img.shields.io/badge/springboot-%3E%3D2.5.5-blue.svg" />
  <img src="https://img.shields.io/badge/maven-%3E%3D3.0.0-blue.svg" />
  <img src="https://img.shields.io/badge/java-%3E%3D1.11.0-blue.svg" />
</p>
<p>
  <a href="https://github.com/dtodo1paco/microfrontends#readme" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="https://github.com/dtodo1paco/microfrontends/graphs/commit-activity" target="_blank">
    <img alt="Maintenance" src="https://img.shields.io/badge/Maintained%3F-yes-green.svg" />
  </a>
  <a href="https://github.com/dtodo1paco/microfrontends/container/blob/master/container/LICENSE.md" target="_blank">
    <img alt="License: BSD 2-Clause" src="https://img.shields.io/badge/BSD2-BSD%202--clause-yellowgreen" />
  </a>
  <a href="https://twitter.com/dtodo1paco" target="_blank">
    <img alt="Twitter: dtodo1paco" src="https://img.shields.io/twitter/follow/dtodo1paco.svg?style=social" />
  </a>
  <a href="https://github.com/dtodo1paco" target="_blank">
    <img alt="Github: dtodo1paco" src="https://img.shields.io/github/followers/dtodo1paco?style=social" />
  </a>
</p>
<!-- TABLE OF CONTENTS -->
<details open="close">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#run">Run</a></li>
      </ul>
    </li>
    <li><a href="#comments">Some comments</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
Recently, I've taken a course about GraphDB in Udemy and I'd like to try it out with a simple backend written in Springboot.

I've used the course exercises as an example to write some endpoints.

## TL;TR; 
This is a simple backend to connect with a Neo4J Graph database through an API.


### Built With
<p>
    <img src="https://img.shields.io/badge/springboot-%3E%3D2.5.5-blue.svg" />
 as the framework
</p><p>
  <img src="https://img.shields.io/badge/maven-%3E%3D3.0.0-blue.svg" />
      to build the project
</p><p>
  <img src="https://img.shields.io/badge/java-%3E%3D1.11.0-blue.svg" /> as the programming language
</p>

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

You need to have a JDK (>=11)) engine installed in your system (see [how to install](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A))

You need a Neo4J database up and running [how to install Neo4j](https://neo4j.com/docs/operations-manual/current/installation/) or a [Dockerized container](https://hub.docker.com/_/neo4j). Just keep your database server info to provide to the project in order to connect both. 

### Installation
Just follow these simple steps

1.Clone the repo
  ```sh
  git clone https://github.com/dtodo1paco/graphdb-springboot.git
  ```
2.Change to the new created directory
  ```
  cd graphdb-springboot
  ```
3.Build the package
  ```
  $ mvn clean package
  ```
4.Now, you're ready to run it (check the current version)
  ```
  $ java -jar ./target/demo-0.0.1.jar 
  ```

<!-- extra comments -->
## Comments
Some interesting comments I've found during the development:
- `spring-data-neo4j` is not fully ready to start, but it allows you to use the `Neo4JClient` with dynamic queries
- That means that you can build labels dynamically, but it makes harder to keep track of the complex queries to get there
- Thanks to that, you can export repository layer with a fully REST API  
- Separation of responsibilities: 
I've made a `DBA` (Data Base Access) layer to keep the service layer isolated from the custom queries outside the standard Repository layer of Springboot

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- LICENSE -->
## License

See [`LICENSE`](LICENSE.md) file for more information.

<!-- CONTACT -->
## Contact

👤 **Paco Alías**

* Website: https://dtodo1paco.github.io/
* Twitter: [@dtodo1paco](https://twitter.com/dtodo1paco)
* Github: [@dtodo1paco](https://github.com/dtodo1paco)
* LinkedIn: [@dtodo1paco](https://linkedin.com/in/dtodo1paco)

<h1 align="center"> 🕵️‍♂️JOB SEARCH PORTAL</h1>

>### Framework Used 
 * ![SpringBoot](https://img.shields.io/badge/SpringBoot-White?style=flat&logoColor=Blue)

>### Language Used
* ![Java](https://img.shields.io/badge/Java-White?style=flat&logoColor=Blue)
>## Data flow
In this project, we have four layers-
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.
* **Database Design**

      - Used H2 Database
      
		      table job (
        	      job_id bigint not null,
        	      applied_date date not null,
        	      company_name varchar(255) not null,
        	      description varchar(255) not null,
        	      employer_name varchar(255) not null,
        	      job_type varchar(255) not null,
        	      location varchar(255) not null,
        	      salary float(53) not null,
        	      title varchar(255) not null,
        	      primary key (job_id)
        )
    
      
      
>## Data Structure used in my project
- List


>## Project Summary
This is a Spring Boot project of Job Search Portal. Companies can register their jobs data by filling the required information.
  Upon registration basic validation applied to filled data if all the validation passes then and only then a data is registered into the portal.
  Companies can able to fetch their saved job information , can able to update the information ,
  as well as can able to unregister/delete the job data from the portal if they want to.
  Also using this portal candidates can able search for their required jobs based on job's title , date , salary and keyword. Here, keyword will be
  matched against the job description then, jobs data will be fetched.

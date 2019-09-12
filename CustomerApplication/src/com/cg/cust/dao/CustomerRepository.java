//extend from crud repository or jpa repository
//dao implementation

package com.cg.cust.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cust.dto.Customer;
@Repository            //integer ---Generic Type Bean class,the data type of the primary key (serializable type corresponding class of integer) which we want to manage
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

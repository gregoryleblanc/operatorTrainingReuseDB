package edu.ohio.inpp.acceleratorOperators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMethod;



@Controller // This means that this class is a Controller
@RequestMapping(path="/training") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;
  @Autowired
  private CertificationRepository certRepository;
  @Autowired
  private CanCertifyRepository canCertifyRepository;
  @Autowired 
  private OpTrainingRepository opTrainingRepository;
  @Autowired
  private TrainerRepository trainerRepository;
  @Autowired
  private AnnualRadSafetyRepository annualRadSafetyRepository;
  @Autowired
  private OperatorRepository operatorRepository;

  //Operators Section
  ////////////////////////////////////////////////
  @PostMapping(path="/user/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/user/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

  @GetMapping(path="/user/count")
  public @ResponseBody Long countUsers() {
    return userRepository.countByStatus("Active");
  }

  @GetMapping(path="/user/active")
  public @ResponseBody Iterable<User> getActive() {
    return userRepository.findByStatus("Active");
  }

  //Certification Section
  ////////////////////////////////////////////////
  @GetMapping(path="/certs/all")
  public @ResponseBody Iterable<Certification> getAllCerts() {
    return certRepository.findAll();
  }  

  //CanCertify Section
  ////////////////////////////////////////////////
  @GetMapping(path="/cancertify/all")
  public @ResponseBody Iterable<CanCertify> getCanCertify() {
    return canCertifyRepository.findAll();
  }

  //OpTraining Section
  ////////////////////////////////////////////////
  @GetMapping(path="/optraining/all")
  public @ResponseBody Iterable<OpTraining> getOpTraining() {
    return opTrainingRepository.findAll();
  }

  //Trainer Section
  ////////////////////////////////////////////////
  @GetMapping(path="/trainer/all")
  public @ResponseBody Iterable<Trainer> getTrainer() {
    return trainerRepository.findAll();
  }

  //AnnualRadSafety Section
  ////////////////////////////////////////////////
  @GetMapping(path="/radsafety/all")
  public @ResponseBody Iterable<AnnualRadSafety> getRadSafety() {
    return annualRadSafetyRepository.findAll();
  }

  //Real Operator Section
  ////////////////////////////////////////////////
  @GetMapping(path="/operator/all")
  public @ResponseBody Iterable<User> getRealOperator() {
    return operatorRepository.findAll();
  }

}
package com.project.Services;

import com.project.POJOClasses.Phone;
import com.project.POJOClasses.User;
import com.project.Repositories.PhoneRepository;
import com.project.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PhoneService{
    private final PhoneRepository phoneRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public PhoneService(PhoneRepository phoneRepository, UserRepository userRepository, EntityManager entityManager) {
        this.phoneRepository = phoneRepository;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    public void addPhone(Phone phone, long userId) {
        User user = userRepository.findById(userId);
        Phone phoneToAdd = new Phone(phone.getPhoneType(), phone.getPhoneNumber(), user);
        user.getPhones().add(phoneToAdd);
        phoneRepository.save(phoneToAdd);
    }

    public Phone findPhoneById(long id) { return phoneRepository.findById(id); }

    public void deletePhone(Phone phone){
        phoneRepository.delete(phone);
    }

    public Phone findPhoneByPhoneNumber(String phoneNumber){
        return phoneRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Phone> findAllUserPhones(long userId){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> query = criteriaBuilder.createQuery(Phone.class);
        Root<User> user = query.from(User.class);
        Join<User, Phone> phones = user.join("phones");
        query = query.select(phones).where(criteriaBuilder.equal(user.get("id"), userId));
        TypedQuery<Phone> q = entityManager.createQuery(query);
        return q.getResultList();
    }

}

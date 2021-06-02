package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.AbilityService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.AbilityDao;
import kodlamaio.hrms.Entities.Concretes.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;
    @Autowired
    public AbilityManager(AbilityDao abilityDao) {
        this.abilityDao = abilityDao;
    }


    @Override
    public DataResult<List<Ability>> getAll() {
        return new SuccessDataResult<List<Ability>>(abilityDao.findAll(),"yenetekler listelendi");
    }

    @Override
    public Result add(Ability ability) {
        abilityDao.save(ability);
        return new SuccessResult("Başarıyla eklendi");
    }
}

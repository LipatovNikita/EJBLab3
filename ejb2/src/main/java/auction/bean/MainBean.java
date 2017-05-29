package auction.bean;

import auction.experiments.ExperimentBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MainBean {

    @EJB
    ExperimentBean experimentBean;

    public String getFirstExperiment() {
        return experimentBean.firstExperiment();
    }

    public String getSecondExperiment() {
        return experimentBean.secondExperiment();
    }

    public String getThirdExperiment() {
        return experimentBean.thirdExperiment();
    }
}

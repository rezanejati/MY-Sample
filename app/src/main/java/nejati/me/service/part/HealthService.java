package nejati.me.service.part;

import org.jetbrains.annotations.NotNull;

import nejati.me.service.generator.ServiceGenerator;
import nejati.me.service.listener.OnServiceStatus;
import nejati.me.service.model.healthStatusModel.response.HealthStatusResponse;

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i@gmail.com>
 * Copyright © 2017
 */
public class HealthService  extends BasePart {
    public HealthService(ServiceGenerator serviceGenerator) {
        super(serviceGenerator);
    }

    @NotNull
    @Override
    protected BasePart getPart() {
        return this;
    }
    public void healthService(OnServiceStatus<HealthStatusResponse> listener) {
        start(getServiceGenerator().createService().health(), listener);
    }
}
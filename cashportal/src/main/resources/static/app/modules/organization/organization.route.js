(function () {
    'use strict';
    angular.module('app.organization').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'addOrganization',
                config: {
                    url: '/addOrganization',
                    templateUrl: 'app/modules/organization/AddOrganization.html',
                    controller: 'AddOrganizationController as vm'
                }
            }
        ];
    }
})();
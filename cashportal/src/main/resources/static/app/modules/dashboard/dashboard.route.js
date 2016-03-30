(function () {
    'use strict';
    angular.module('app.dashboard').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'app.dashboard',
                config: {
                    url: '/dashboard',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/dashboard/dashboard.html',
                            controller: 'DashboardController as vm'
                        }
                    }
                }
            }
        ];
    }
})();
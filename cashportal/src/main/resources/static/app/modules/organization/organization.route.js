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
                    templateUrl: 'app/modules/organization/OrganizationDetail.html',
                    controller: 'AddOrganizationController as vm'
                }
            },
            {
                state: 'listOrganization',
                config: {
                    url: '/listOrganization',
                    templateUrl: 'app/modules/organization/ListOrganization.html',
                    controller: 'ListOrganizationController as vm'
                }
            },
            {
                state: 'viewOrganization',
                config: {
                    url: '/viewOrganization',
                    templateUrl: 'app/modules/organization/OrganizationDetail.html',
                    controller: 'ViewOrganizationController as vm',
                    params: {
                        rid: true
                    },
                    resolve: {
                        organizationDetails: getOrganizationDetailsResolve
                    }
                }
            },
            {
                state: 'editOrganization',
                config: {
                    url: '/editOrganization',
                    templateUrl: 'app/modules/organization/OrganizationDetail.html',
                    controller: 'EditOrganizationController as vm',
                    params: {
                        rid: true
                    },
                    resolve: {
                        organizationDetails: getOrganizationDetailsResolve
                    }
                }
            }
            
        ];
    }
    
    function getOrganizationDetailsResolve(OrganizationService, $stateParams) {
    'ngInject';
    return OrganizationService.getOrganizationDetails($stateParams.rid);
    }
})();
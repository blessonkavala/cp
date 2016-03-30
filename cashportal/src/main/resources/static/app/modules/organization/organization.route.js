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
                state: 'app.addOrganization',
                config: {
                    url: '/addOrganization',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/organization/OrganizationDetail.html',
                            controller: 'AddOrganizationController as vm'
                        }
                    }
                }
            },
            {
                state: 'app.listOrganization',
                config: {
                    url: '/listOrganization',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/organization/ListOrganization.html',
                        controller: 'ListOrganizationController as vm'
                        }
                    }
                }
            },
            {
                state: 'app.viewOrganization',
                config: {
                    url: '/viewOrganization',
                    views: {
                    'mainContent': {
                    templateUrl: 'app/modules/organization/OrganizationDetail.html',
                    controller: 'ViewOrganizationController as vm',
                        }
                    },
                     params: {
                        rid: true
                            },
                    resolve: {
                        organizationDetails: getOrganizationDetailsResolve
                    }
                }
            },
            {
                state: 'app.editOrganization',
                config: {
                    url: '/editOrganization',
                     views: {
                    'mainContent': {
                    templateUrl: 'app/modules/organization/OrganizationDetail.html',
                    controller: 'EditOrganizationController as vm',
                   
                        }
                    },
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
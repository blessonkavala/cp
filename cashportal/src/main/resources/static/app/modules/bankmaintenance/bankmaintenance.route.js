(function () {
    'use strict';
    angular.module('app.bankmaintenance').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'app.listBanks',
                config: {
                    url: '/listBanks',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/bankmaintenance/profiles/ListBanks.html',
                        controller: 'ControllerListBanks as vm'
                        }
                    }
                }
            },
             {
                state: 'app.addBank',
                config: {
                    url: '/addBank',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/bankmaintenance/profiles/BankDetail.html',
                            controller: 'ControllerAddBank as vm'
                        }
                    }
                }
            },
             {
                state: 'app.viewBank',
                config: {
                    url: '/viewBank',
                    views: {
                    'mainContent': {
                    templateUrl: 'app/modules/bankmaintenance/profiles/BankDetail.html',
                    controller: 'ControllerViewBank as vm',
                        }
                    },
                    params: {
                        rid: true
                            },
                    resolve: {
                        organizationDetails: getBankDetailsResolve
                    }
                }
            },
            {
                state: 'app.editBank',
                config: {
                    url: '/editBank',
                     views: {
                    'mainContent': {
                    templateUrl: 'app/modules/bankmaintenance/profiles/BankDetail.html',
                    controller: 'ControllerEditBank as vm',
                   
                        }
                    },
                     params: {
                        rid: true
                            },
                    resolve: {
                        organizationDetails: getBankDetailsResolve
                    }
                }
            },
            {
                state: 'app.listBanksForSelection',
                config: {
                    url: '/listBanksForSelection',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/bankmaintenance/listBanksForSelection.html',
                        controller: 'ControllerListBanksForSelection as vm'
                        }
                    },
                    params : {
                         targetUIState: null
                    }
                }
            },
            {
                state: 'app.listBankUsers',
                config: {
                    url: '/listBankUsers',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/bankmaintenance/userprofiles/listBankUsers.html',
                        controller: 'ControllerListBankUsers as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
            {
                state: 'app.addBankUser',
                config: {
                    url: '/addBankUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/bankmaintenance/userprofiles/BankUserDetail.html',
                            controller: 'ControllerAddBankUser as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
            {
                state: 'app.viewBankUser',
                config: {
                    url: '/viewBankUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/bankmaintenance/userprofiles/BankUserDetail.html',
                            controller: 'ControllerViewBankUser as vm',
                        }
                    },
                    params: {
                        rid: true
                    },
                    resolve: {
                        userDetails: getBankUserDetailsResolve
                    }
                }
            },
            {
                state: 'app.editBankUser',
                config: {
                    url: '/editBankUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/bankmaintenance/userprofiles/BankUserDetail.html',
                            controller: 'ControllerEditBankUser as vm',
                        }
                    },
                    params: {
                        rid: true
                    },
                    resolve: {
                        userDetails: getBankUserDetailsResolve
                    }
                }
            },
            {
                state: 'app.listBankPermissions',
                config: {
                    url: '/listBankPermissions',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/bankmaintenance/permissions/listBankPermissions.html',
                        controller: 'ControllerListBankPermissions as vm'
                        }
                    }
                }
            },
            {
                state: 'app.editBankPermissions',
                config: {
                    url: '/editBankPermissions',
                     views: {
                    'mainContent': {
                    templateUrl: 'app/modules/bankmaintenance/permissions/BankPermissionsDetail.html',
                    controller: 'ControllerEditBankPermissions as vm',
                   
                        }
                    },
                     params: {
                        orgId: true
                            },
                    resolve: {
                        organizationRoles: getOrganizationRolesResolve
                    }
                }
            },
            {
                state: 'app.viewBankPermissions',
                config: {
                    url: '/viewBankPermissions',
                     views: {
                    'mainContent': {
                    templateUrl: 'app/modules/bankmaintenance/permissions/BankPermissionsDetail.html',
                    controller: 'ControllerViewBankPermissions as vm',
                   
                        }
                    },
                     params: {
                        orgId: true
                            },
                    resolve: {
                        organizationRoles: getOrganizationRolesResolve
                    }
                }
            },
            //BANK USER PERMISSION ROUTING
            {
                state: 'app.listBankUsersPermissions',
                config: {
                    url: '/listBankUsersPermissions',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/bankmaintenance/userpermissions/ListBankUsersPermissions.html',
                        controller: 'ControllerListBankUsersPermissions as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
            {
                state: 'app.editBankUserPermissions',
                config: {
                    url: '/editBankUserPermissions',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/bankmaintenance/userpermissions/BankUserPermissionsDetail.html',
                            controller: 'ControllerEditBankUserPermissions as vm',
                        }
                    },
                    params: {
                        userId: true
                    },
                    resolve: {
                        userRoles: getBankUserRolesResolve
                    }
                }
            },
            {
                state: 'app.viewBankUserPermissions',
                config: {
                    url: '/viewBankUserPermissions',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/bankmaintenance/userpermissions/BankUserPermissionsDetail.html',
                            controller: 'ControllerViewBankUserPermissions as vm',
                        }
                    },
                    params: {
                        userId: true
                    },
                    resolve: {
                        userRoles: getBankUserRolesResolve
                    }
                }
            }
        ];
    }
    
    function getBankUserDetailsResolve(UserService, $stateParams) {
    'ngInject';
    return UserService.getUserDetails($stateParams.rid);
    }
    
    function getBankDetailsResolve(OrganizationService, $stateParams) {
    'ngInject';
    return OrganizationService.getOrganizationDetails($stateParams.rid);
    }
    
    function getOrganizationRolesResolve(OrganizationRoleService, $stateParams) {
    'ngInject';
    return OrganizationRoleService.getOrganizationRoles($stateParams.orgId);
    }
    
    function getBankUserRolesResolve(UserRoleService, $stateParams) {
    'ngInject';
    return UserRoleService.getUserRoles($stateParams.userId);
    }
})();
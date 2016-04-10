(function () {
    'use strict';
    angular.module('app.customermaintenance').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'app.listCustomers',
                config: {
                    url: '/listCustomers',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/customermaintenance/profiles/ListCustomers.html',
                        controller: 'ControllerListCustomers as vm'
                        }
                    }
                }
            },
             {
                state: 'app.addCustomer',
                config: {
                    url: '/addCustomer',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/profiles/CustomerDetail.html',
                            controller: 'ControllerAddCustomer as vm'
                        }
                    }
                }
            },
             {
                state: 'app.viewCustomer',
                config: {
                    url: '/viewCustomer',
                    views: {
                    'mainContent': {
                    templateUrl: 'app/modules/customermaintenance/profiles/CustomerDetail.html',
                    controller: 'ControllerViewCustomer as vm',
                        }
                    },
                    params: {
                        rid: true
                            },
                    resolve: {
                        organizationDetails: getCustomerDetailsResolve
                    }
                }
            },
            {
                state: 'app.editCustomer',
                config: {
                    url: '/editCustomer',
                     views: {
                    'mainContent': {
                    templateUrl: 'app/modules/customermaintenance/profiles/CustomerDetail.html',
                    controller: 'ControllerEditCustomer as vm',
                   
                        }
                    },
                     params: {
                        rid: true
                            },
                    resolve: {
                        organizationDetails: getCustomerDetailsResolve
                    }
                }
            },
            {
                state: 'app.listCustomersForSelection',
                config: {
                    url: '/listCustomersForSelection',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/customermaintenance/listCustomersForSelection.html',
                        controller: 'ControllerListCustomersForSelection as vm'
                        }
                    },
                    params : {
                         targetUIState: null
                    }
                }
            },
            {
                state: 'app.listCustomerUsers',
                config: {
                    url: '/listCustomerUsers',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/customermaintenance/userprofiles/listCustomerUsers.html',
                        controller: 'ControllerListCustomerUsers as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
            {
                state: 'app.addCustomerUser',
                config: {
                    url: '/addCustomerUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/userprofiles/CustomerUserDetail.html',
                            controller: 'ControllerAddCustomerUser as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
            {
                state: 'app.viewCustomerUser',
                config: {
                    url: '/viewCustomerUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/userprofiles/CustomerUserDetail.html',
                            controller: 'ControllerViewCustomerUser as vm',
                        }
                    },
                    params: {
                        rid: true
                    },
                    resolve: {
                        userDetails: getCustomerUserDetailsResolve
                    }
                }
            },
            {
                state: 'app.editCustomerUser',
                config: {
                    url: '/editCustomerUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/userprofiles/CustomerUserDetail.html',
                            controller: 'ControllerEditCustomerUser as vm',
                        }
                    },
                    params: {
                        rid: true
                    },
                    resolve: {
                        userDetails: getCustomerUserDetailsResolve
                    }
                }
            },
            {
                state: 'app.listCustomerPermissions',
                config: {
                    url: '/listCustomerPermissions',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/customermaintenance/permissions/listCustomerPermissions.html',
                        controller: 'ControllerListCustomerPermissions as vm'
                        }
                    }
                }
            },
            {
                state: 'app.editCustomerPermissions',
                config: {
                    url: '/editCustomerPermissions',
                     views: {
                    'mainContent': {
                    templateUrl: 'app/modules/customermaintenance/permissions/CustomerPermissionsDetail.html',
                    controller: 'ControllerEditCustomerPermissions as vm',
                   
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
                state: 'app.viewCustomerPermissions',
                config: {
                    url: '/viewCustomerPermissions',
                     views: {
                    'mainContent': {
                    templateUrl: 'app/modules/customermaintenance/permissions/CustomerPermissionsDetail.html',
                    controller: 'ControllerViewCustomerPermissions as vm',
                   
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
            //Customer USER PERMISSION ROUTING
            {
                state: 'app.listCustomerUsersPermissions',
                config: {
                    url: '/listCustomerUsersPermissions',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/customermaintenance/userpermissions/ListCustomerUsersPermissions.html',
                        controller: 'ControllerListCustomerUsersPermissions as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
            {
                state: 'app.editCustomerUserPermissions',
                config: {
                    url: '/editCustomerUserPermissions',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/userpermissions/CustomerUserPermissionsDetail.html',
                            controller: 'ControllerEditCustomerUserPermissions as vm',
                        }
                    },
                    params: {
                        userId: true
                    },
                    resolve: {
                        userRoles: getCustomerUserRolesResolve
                    }
                }
            },
            {
                state: 'app.viewCustomerUserPermissions',
                config: {
                    url: '/viewCustomerUserPermissions',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/userpermissions/CustomerUserPermissionsDetail.html',
                            controller: 'ControllerViewCustomerUserPermissions as vm',
                        }
                    },
                    params: {
                        userId: true
                    },
                    resolve: {
                        userRoles: getCustomerUserRolesResolve
                    }
                }
            },
             //Customer Accounts
            {
                state: 'app.listCustomerAccounts',
                config: {
                    url: '/listCustomerAccounts',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/customermaintenance/accounts/ListCustomerAccounts.html',
                        controller: 'ControllerListCustomerAccounts as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
             {
                state: 'app.addCustomerAccount',
                config: {
                    url: '/addCustomerAccount',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/accounts/CustomerAccountDetail.html',
                            controller: 'ControllerAddCustomerAccount as vm'
                        }
                    },
                    params : {
                         selectedOrgId: null
                    }
                }
            },
            {
                state: 'app.editCustomerAccount',
                config: {
                    url: '/editCustomerAccount',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/accounts/CustomerAccountDetail.html',
                            controller: 'ControllerEditCustomerAccount as vm',
                        }
                    },
                    params: {
                        customerAccountId: true
                    },
                    resolve: {
                        customerAccount: getCustomerAccountDetailsResolve
                    }
                }
            },
             {
                state: 'app.viewCustomerAccount',
                config: {
                    url: '/viewCustomerAccount',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/customermaintenance/accounts/CustomerAccountDetail.html',
                            controller: 'ControllerViewCustomerAccount as vm',
                        }
                    },
                    params: {
                        customerAccountId: true
                    },
                    resolve: {
                        customerAccount: getCustomerAccountDetailsResolve
                    }
                }
            }
        ];
    }
    
    function getCustomerUserDetailsResolve(UserService, $stateParams) {
    'ngInject';
    return UserService.getUserDetails($stateParams.rid);
    }
    
    function getCustomerDetailsResolve(OrganizationService, $stateParams) {
    'ngInject';
    return OrganizationService.getOrganizationDetails($stateParams.rid);
    }
    
    function getOrganizationRolesResolve(OrganizationRoleService, $stateParams) {
    'ngInject';
    return OrganizationRoleService.getOrganizationRoles($stateParams.orgId);
    }
    
    function getCustomerUserRolesResolve(UserRoleService, $stateParams) {
    'ngInject';
    return UserRoleService.getUserRoles($stateParams.userId);
    }
    
    function getCustomerAccountDetailsResolve(AccountService, $stateParams) {
    'ngInject';
    return AccountService.getCustomerAccountDetails($stateParams.customerAccountId);
    }
    
    
})();
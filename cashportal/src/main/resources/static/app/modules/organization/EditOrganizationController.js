(function () {
    'use strict';
    angular.module('app.organization').controller('EditOrganizationController', EditOrganizationController);
    /* @ngInject */
    function EditOrganizationController(OrganizationService,organizationDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit Party';
        vm.isView = false;
        vm.isEdit = true;
        vm.org = organizationDetails;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        
        vm.updateOrganization = function (org) {
       
        	$http.put('/organization/update',org).then(function(response){
        		$state.go('listOrganization');
        		console.log(response);
        	});
        	
        };
        
         function cancel() {
        	$state.go('main.partymanagement-dashboard');
        }
      
    }
})();
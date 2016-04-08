(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerListBanksForSelection', ControllerListBanksForSelection);
    /* @ngInject */
    function ControllerListBanksForSelection(OrganizationService,$state, $rootScope, $http , $stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.organizations = null;
        OrganizationService.getOrganizationList().then(handleOrganizationList);
        vm.resolveNextState = resolveNextState;
        console.log($stateParams.dest);
        
        function handleOrganizationList(organizations) {
            vm.organizations = organizations;
        }
        
        function resolveNextState(org)
        {
            console.log(org,$stateParams.targetUIState);
            $state.go($stateParams.targetUIState, {selectedOrgId: org.rid});
        }
    }
})();
(function() {
	'use strict';
    angular
        .module('app.middleoffice')
        .factory('MiddleOfficeService', MiddleOfficeService);

    /* @ngInject */
    function MiddleOfficeService($http) {
    var service = {
        getPendingRecords: getPendingRecords
        
    };
    return service;
    
    function getPendingRecords(tnxStatCode) {
        return $http.post('/middleoffice/list', {tnxStatCode:tnxStatCode}).then(getCompleteHandler);
            function getCompleteHandler(response) {
                return response.data;
            }
    }
    
    function getFundTransferDetails(rid) {
        return $http.post('/ft/query', {rid:rid}).then(getCompleteHandler);
            function getCompleteHandler(response) {
                return response.data;
            }
    }
    
    function getTransactionStatusCodes() {
        var statusCodes = [
            {'code': '03', 'value': 'Submitted (Pending for Approval)'},
            {'code': '04', 'value': 'Approved'},
            {'code': '01', 'value': 'Rejected'}
        ];
        return statusCodes;
    }
}
})();
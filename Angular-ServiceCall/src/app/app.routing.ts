import {RouterModule, Routes} from '@angular/router';
import {ActionsComponent} from "./actions/actions.component";
import {ChargeCodesComponent} from "./charge-codes/charge-codes.component";
import {ContactsComponent} from "./contacts/contacts.component";
import {CustomersComponent} from "./customers/customers.component";
import {OutcomeCodesComponent} from "./outcome-codes/outcome-codes.component";
import {ProblemsComponent} from "./problems/problems.component";
import {ServiceRequestActionsComponent} from "./service-request-actions/service-request-actions.component";
import {ServiceRequestCallsComponent} from "./service-request-calls/service-request-calls.component";
import {StatusCodesComponent} from "./status-codes/status-codes.component";
import {TechniciansComponent} from "./technicians/technicians.component";
import {CustomerCreateComponent} from "./customers/customer-create/customer-create.component";
import {ChargeCodesCreateComponent} from "./charge-codes/charge-codes-create/charge-codes-create.component";
import {ChargeCodesEditComponent} from "./charge-codes/charge-codes-edit/charge-codes-edit.component";
import {ActionsCreateComponent} from "./actions/actions-create/actions-create.component";
import {ActionsEditComponent} from "./actions/actions-edit/actions-edit.component";
import {ProblemsCreateComponent} from "./problems/problems-create/problems-create.component";
import {ProblemsEditComponent} from "./problems/problems-edit/problems-edit.component";
import {StatusCodeCreateComponent} from "./status-codes/status-code-create/status-code-create.component";
import {StatusCodeEditComponent} from "./status-codes/status-code-edit/status-code-edit.component";
import {TechniciansCreateComponent} from "./technicians/technicians-create/technicians-create.component";
import {TechniciansEditComponent} from "./technicians/technicians-edit/technicians-edit.component";
import {OutcomeCodesCreateComponent} from "./outcome-codes/outcome-codes-create/outcome-codes-create.component";
import {OutcomeCodesEditComponent} from "./outcome-codes/outcome-codes-edit/outcome-codes-edit.component";
import {CustomerEditComponent} from "./customers/customer-edit/customer-edit.component";

const routes: Routes = [
  {path: 'actions', component: ActionsComponent},
  {path: 'charge-codes', component: ChargeCodesComponent},
  {path: 'contacts', component: ContactsComponent},
  {path: 'customers', component: CustomersComponent},
  {path: 'outcome-codes', component: OutcomeCodesComponent},
  {path: 'problems', component: ProblemsComponent},
  {path: 'service-request-actions', component: ServiceRequestActionsComponent},
  {path: 'service-request-calls', component: ServiceRequestCallsComponent},
  {path: 'status-codes', component: StatusCodesComponent},
  {path: 'technicians', component: TechniciansComponent},
  {path: 'customers/create', component: CustomerCreateComponent},
  {path: 'customers/edit', component: CustomerEditComponent},
  {path: 'charge-codes/create', component: ChargeCodesCreateComponent},
  {path: 'charge-codes/edit', component: ChargeCodesEditComponent},
  {path: 'actions/create', component: ActionsCreateComponent},
  {path: 'actions/edit', component: ActionsEditComponent},
  {path: 'outcome-codes/create', component: OutcomeCodesCreateComponent},
  {path: 'outcome-codes/edit', component: OutcomeCodesEditComponent},
  {path: 'problems/create', component: ProblemsCreateComponent},
  {path: 'problems/edit', component: ProblemsEditComponent},
  {path: 'status-codes/create', component: StatusCodeCreateComponent},
  {path: 'status-codes/edit', component: StatusCodeEditComponent},
  {path: 'technicians/create', component: TechniciansCreateComponent},
  {path: 'technicians/edit', component: TechniciansEditComponent},
  {path: '', component: CustomersComponent},
]
export const routing = RouterModule.forRoot(routes);

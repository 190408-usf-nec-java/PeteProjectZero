export class Reimbursements {

    id: number;
    amount: number;
    description: String;
    author: number;
    resolver: number;
    status_id: number;
    type_Id: number;

    constructor(id: number, amount: number, description: String, author: number, 
        resolver: number, status_id: number, type_Id: number){
            this.id = id;
            this.amount = amount;
            this.author = author;
            this.resolver = resolver;
            this.status_id = status_id;
            this.type_Id = type_Id;
            this.description = description;
        }
}
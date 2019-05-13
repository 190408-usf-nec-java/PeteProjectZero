export class Users {

    id: number;
    username: string;
    password: string;
    firstname: string;
    lastname: string;
    email: string;
    role_id: number;

    constructor(id: number, username: string, password: string,
        firstname: string, lastname: string, email: string,
        role_id: number){
            this.id = id;
            this.username = username;
            this.password = password;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.role_id = role_id;
        }
}
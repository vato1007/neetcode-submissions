class LinkedList {
private:
    struct Node {
        int val;
        Node* next;

        Node(int val) {
            this->val = val;
            this->next = nullptr;
        }
    };

    Node* head;

public:
    LinkedList() {
        head = nullptr;
    }

    int get(int i) {
        Node* curr = head;

        for (int j = 0; j < i; j++) {
            if (curr == nullptr)
                return -1;

            curr = curr->next;
        }

        if (curr == nullptr)
            return -1;

        return curr->val;
    }

    void insertHead(int val) {
        Node* newNode = new Node(val);

        newNode->next = head;
        head = newNode;
    }

    void insertTail(int val) {
        Node* newNode = new Node(val);

        if (head == nullptr) {
            head = newNode;
            return;
        }

        Node* curr = head;

        while (curr->next != nullptr) {
            curr = curr->next;
        }

        curr->next = newNode;
    }

    bool remove(int i) {
        if (head == nullptr)
            return false;

        // Removing the head
        if (i == 0) {
            Node* temp = head;
            head = head->next;
            delete temp;
            return true;
        }

        Node* curr = head;

        // Move to node BEFORE the one we want to remove
        for (int j = 0; j < i - 1; j++) {
            if (curr->next == nullptr)
                return false;

            curr = curr->next;
        }

        // i is out of bounds
        if (curr->next == nullptr)
            return false;

        Node* temp = curr->next;
        curr->next = temp->next;

        delete temp;

        return true;
    }

    vector<int> getValues() {
        vector<int> result;

        Node* curr = head;

        while (curr != nullptr) {
            result.push_back(curr->val);
            curr = curr->next;
        }

        return result;
    }
};
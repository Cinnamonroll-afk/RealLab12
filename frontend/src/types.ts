// The existing Event and Organizer interfaces remain the same.
export interface Event {
  id: number
  category: string
  title: string
  description: string
  location: string
  date: string
  time: string
  petAllowed: boolean
  organizer: Organizer
  participants: Participant[] // This might be used in EventDetail view
}

export interface Organizer {
  id: number
  name: string
}

// New simplified event type to match the ParticipantEventDTO from the backend.
// This prevents recursive data issues.
export interface ParticipantEvent {
    id: number;
    category: string;
    title: string;
    location: string;
    date: string;
    time: string;
}

// The Participant interface now uses the simplified ParticipantEvent type.
export interface Participant {
  id: number
  name: string
  telNo: string
  eventHistory: ParticipantEvent[] // Use the new simplified type here
}
